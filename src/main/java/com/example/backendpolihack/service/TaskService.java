package com.example.backendpolihack.service;

import com.example.backendpolihack.models.*;
import com.example.backendpolihack.models.dto.SubTaskDto;
import com.example.backendpolihack.models.dto.TaskDto;
import com.example.backendpolihack.repository.MentorRepository;
import com.example.backendpolihack.repository.StudentRepository;
import com.example.backendpolihack.repository.TaskRepository;
import com.example.backendpolihack.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskDto> getTasks(org.springframework.security.core.userdetails.User authUser) throws Exception {
        User user = userRepository.findByEmail(authUser.getUsername()).orElse(null);
        if (user == null){
            throw new Exception();
        }
        List<Task> tasks  = studentRepository.findByUserId(user.getId()).getTasks().stream().collect(Collectors.toList());
        List<TaskDto> response = new ArrayList<>();
        for (Task task : tasks){
            response.add(new TaskDto(task));
        }
        return response;
    }

    @Override
    @PreAuthorize("hasRole('MENTOR')")
    public TaskDto saveTask(org.springframework.security.core.userdetails.User authUser, TaskDto taskDto) throws Exception {
        User user = userRepository.findByEmail(authUser.getUsername()).orElse(null);
        if (user == null){
            throw new Exception();
        }
        Set<Student> students = mentorRepository.findByUserId(user.getId()).getStudents();
        Student student = studentRepository.getById(taskDto.getStudentId());
        boolean studentExist = false;
        for (Student setStudent : students){
            if (Objects.equals(setStudent.getId(), setStudent.getId())){
                studentExist = true;
                break;
            }
        }
        if (!studentExist){
            throw new Exception();
        }
        Task task = new Task();
        task.setStudent(student);
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        return null;
    }

    @Override
    @PreAuthorize("hasRole('STUDENT')")
    public TaskDto updateTask(org.springframework.security.core.userdetails.User authUser, TaskDto taskDto) {
        //User user = userRepository.findByEmail(authUser.getUsername()).orElse(null);
        Task task = taskRepository.findById(taskDto.getId()).orElse(null);
        Map<Long, SubTaskDto> subTaskMap = new HashMap<>();
        for (SubTaskDto subTaskDto : taskDto.getSubTasks()){
            subTaskMap.put((long)subTaskDto.getId(), subTaskDto);
        }
        for (SubTask subTask : task.getSubTasks()){
            SubTaskDto subTaskDto = subTaskMap.get(subTask.getId());
            subTask.setDone(subTaskDto.isDone());
        }
        task = taskRepository.save(task);
        return new TaskDto(task);
    }
}
