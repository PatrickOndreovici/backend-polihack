package com.example.backendpolihack.security.services;

import com.example.backendpolihack.models.Mentor;
import com.example.backendpolihack.models.Student;
import com.example.backendpolihack.models.Task;
import com.example.backendpolihack.models.User;
import com.example.backendpolihack.models.dto.TaskDto;
import com.example.backendpolihack.repository.MentorRepository;
import com.example.backendpolihack.repository.StudentRepository;
import com.example.backendpolihack.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
}
