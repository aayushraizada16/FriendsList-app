package com.example.freindlist.controller;


import com.example.freindlist.entity.User;
import com.example.freindlist.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.freindlist.dto.ResponseDTO;


import java.util.List;
import java.util.Optional;

@RestController
public class FriendListController {


    @Autowired
    private FriendService friendService;


    @RequestMapping("/users")
    public List<User> getAllUsers()
    {
        return friendService.getAllUsers();

    }

    @RequestMapping("/users/{id}")
    public Optional<User> getjob(@PathVariable Integer id)
    {
        return friendService.getUser(id);

    }

    @RequestMapping(method = RequestMethod.POST,value = "/newuser")
    public ResponseDTO addUser(@RequestBody User user)
    {

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setId(friendService.addUsers(user));
        responseDTO.setStatus("SUCCESS");

        return responseDTO;


    }

    @RequestMapping("/connect")
    public ResponseDTO connection(@RequestParam("user1") Integer user1 ,
                              @RequestParam("user2") Integer user2)
    {


        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setId(friendService.connection(user1,user2));
        responseDTO.setStatus("Connection Successfull for Below user id");

        return responseDTO;
    }


    @RequestMapping("/distance")
    public ResponseDTO distance(@RequestParam("user1") Integer user1 ,
                              @RequestParam("user2") Integer user2)
    {

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setId(friendService.getDistance(user1,user2));

        if (responseDTO.getId()== -1)
        {
            responseDTO.setStatus("No Connection Found");
        }

        else
        {
            responseDTO.setStatus("Total Distance");
        }

        return responseDTO;
    }


    @RequestMapping("/myfriendlist")
    public List<User> getmyfriendlist(@RequestParam("user1") Integer user1)
    {
        return friendService.getimmediatefreinds(user1);

    }

    @RequestMapping("/remove")
    public ResponseDTO remove(@RequestParam("user1") Integer user1,@RequestParam("user2") Integer user2 )
    {


        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setId(friendService.removeconnection(user1,user2));
        responseDTO.setStatus("Connection Removed for Below user id");

        return responseDTO;
    }

}
