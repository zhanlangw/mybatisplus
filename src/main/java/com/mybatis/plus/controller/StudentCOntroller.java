package com.mybatis.plus.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentCOntroller implements ApiUser {

    @PostMapping("/api/asdfe/(id)")
    @ApiOperation(value = "接口说明")
    public String testSwagger2(@RequestParam @ApiParam("id") String id) {
        return id;
    }

    @GetMapping("/wefasfsdf/aaaa")
    @ApiOperation(value = "接口说明", notes = "aaad的接口")
    @ApiParam(name = "参数", value = "这是描述参数")
    public String aaa(@ApiParam() String name, @RequestParam @ApiParam(value = "年龄值", name = "年龄", required = true) Integer age) {
        return name + age;
    }

    @PostMapping("/gqewrasf/{name}/asdfeasd")
    @Override
    public String test(String id, @PathVariable String name, @RequestBody Student student) {
        return student.getName()+student.getAge()+id+name;
    }
}
