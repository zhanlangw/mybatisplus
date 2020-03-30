package com.mybatis.plus.controller;

import io.swagger.annotations.*;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("asdfasdwef")
public class UserController {

    @PostMapping("/api/test/(id)")
    @ApiOperation(value = "接口说明")
    public String testSwagger2(@RequestParam @ApiParam("id") String id) {
        return id;
    }

    @GetMapping("/api/aaaa")
    @ApiOperation(value = "接口说明", notes = "aaad的接口")
    @ApiParam(name = "参数", value = "这是描述参数")
    public String aaa(@ApiParam() String name, @RequestParam @ApiParam(value = "年龄值", name = "年龄", required = true) Integer age) {
        return name + age;
    }

    @PostMapping("/api/{name}/asdfeasd")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="id",value = "用户di",paramType = "query",required = true,dataType = "string"),
            @ApiImplicitParam(name ="name",value = "用户姓名",paramType = "path",required = true,dataType = "string"),
//            @ApiImplicitParam(name ="student",value = "学生",paramType = "body",required = true),
            @ApiImplicitParam(name = "params" , paramType = "body",examples = @Example({
                    @ExampleProperty(value = "{'user':'id'}", mediaType = "application/json")
            }))
    })
    @ApiOperation("list")
    public String test(String id, @PathVariable String name, @RequestBody Student student, Map<String,Object> params) {
        return student.getName()+student.getAge()+id+name;
    }
}

@Api(value = "随便写点",description = "测试用例")
interface ApiUser{
    @ApiImplicitParams({
            @ApiImplicitParam(name ="id",value = "用户di",paramType = "query",required = true,dataType = "string"),
            @ApiImplicitParam(name ="name",value = "用户姓名",paramType = "path",required = true,dataType = "string"),
            @ApiImplicitParam(name ="name",value = "用户姓名",paramType = "path",required = true,dataType = "string")
    })
    @ApiOperation("list")
    public String test(String id,String name,Student student);
}
@Data
@ApiModel(value = "学生",description ="学生" )
class Student{
    @ApiModelProperty(name = "name",value = "名字",dataType = "string",required = true)
    private String name;

    @ApiModelProperty(name = "age",value = "年龄",dataType = "int")
    private int age;
}