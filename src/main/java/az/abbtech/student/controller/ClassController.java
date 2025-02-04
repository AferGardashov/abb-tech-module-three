package az.abbtech.student.controller;

import az.abbtech.student.dto.req.ReqClassDto;
import az.abbtech.student.dto.resp.RespClassDto;
import az.abbtech.student.service.ClassService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping("/post")
    public void save(@RequestBody ReqClassDto reqClassDto) {
        classService.saveClass(reqClassDto);
    }

    @GetMapping("/get")
    public List<RespClassDto> getAll() {
        return classService.getClasses();
    }

    @GetMapping("/get/{id}")
    public RespClassDto getById(@PathVariable int id) {
        return classService.getClassById(id);
    }

    @PutMapping("/put")
    public void update(@RequestBody ReqClassDto reqClassDto) {
        classService.updateClass(reqClassDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        classService.deleteClass(id);
    }

}
