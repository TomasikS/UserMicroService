package com.example.springbootswagger2.controller;

import com.example.springbootswagger2.model.Database;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootswagger2.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "Swagger2DemoRestController", description = "REST Apis related to entity user")
@RestController
public class Swagger2DemoRestController {

    Database db = new Database();

    @ApiOperation(value = "Get users ", response = Iterable.class )
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Suceess|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!")})
    @GetMapping("/getUsers")
    public String getUsers() {
        List<User> users = new ArrayList();
        users=db.getData();
        return users.toString();
    }
    
    @ApiOperation(value = "Add an user")
    @PostMapping("/users")
    public void createUser(
        @ApiParam(value = "User object store in database table", required = true) @Valid @RequestBody User  user) {
        db.save(user);
    }
    
    
     @ApiOperation(value = "Delete a user")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity delete(@PathVariable int id){
        db.delete(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }

}
