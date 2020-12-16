package com.example.freindlist.service;


import com.example.freindlist.entity.Graph;
import com.example.freindlist.entity.User;
import com.example.freindlist.repository.GraphRepository;
import com.example.freindlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FriendService {



    @Autowired
    UserRepository userRepository;

    @Autowired
    GraphRepository graphRepository;



    //Function for getting all users

    public List<User> getAllUsers(){

        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }


    //Function for getting specific user
    public Optional<User> getUser (Integer id)
    {
        return userRepository.findById(id);
    }


    //Function for creating new users
    public Integer addUsers (User user)
    {

        User user1 = userRepository.save(user);


        return user1.getId();
    }


    //Function for creating new connection between 2 users

    public Integer connection(Integer id1, Integer id2)
    {


        if(userRepository.findById(id1).isPresent() && userRepository.findById(id2).isPresent()) {



            Graph user1 = new Graph();
            user1.setSrc(id1);
            user1.setDest(id2);

            Graph user2 = new Graph();
            user2.setSrc(id2);
            user2.setDest(id1);

            graphRepository.save(user1);
            graphRepository.save(user2);

        }

        return id1;
    }


    //Function for getting the distance between 2 nodes
    public Integer getDistance(Integer id1, Integer id2)
    {

        Integer dist = 0;

        if(userRepository.findById(id1).isPresent() && userRepository.findById(id2).isPresent())
        {

            dist  = distance(id1, id2);

        }

        return dist;


    }

    public Integer distance(int start, int end) {

        List<Graph> users = (List<Graph>) graphRepository.findAll();

        //for getting the distance if it is immidiate neighbour
        for(Graph user : users)
        {
            if (user.getSrc().equals(start) && user.getDest().equals(end))
            {
                return 1;
            }
        }

        //Getting distance rest nodes
        List<User> data = (List<User>) userRepository.findAll();

        boolean[] visited = new boolean[data.size()+1];

            return DFSUtildist(start, visited, 0, end);





    }


    //Utility function based on undirected-graph
    int DFSUtildist(Integer v, boolean[] visited, int dist, int dest) {



        if(v==dest)
            return dist;

        visited[v] = true;



        List<Graph> users = new ArrayList<>();

        graphRepository.findAll().forEach(user -> {
            if (user.getDest().equals(v) || user.getSrc().equals(v))
            {
                users.add(user);
            }
        });

        for(Graph user : users)
        {
            Integer x = user.getSrc();
            if (!visited[x]) {
                return DFSUtildist(x, visited, dist+1, dest);
            }
        }

        return -1;


    }



    // Function for getting the FriendList

    public List<User> getimmediatefreinds(Integer userid){

        List<User> users = new ArrayList<>();


        List<Graph> graph_users = new ArrayList<>();

        graphRepository.findAll().forEach(graph_user -> {
            userRepository.findAll().forEach(user -> {
                        if (graph_user.getDest().equals(userid))
                        {
                            if(graph_user.getSrc()==user.getId())
                            {
                                users.add(user);
                            }

                        }

        });});





        return users;
    }


    // Function for Removing connection between 2 freinds

    public Integer removeconnection(Integer userid1, Integer userid2)
    {


        graphRepository.findAll().forEach(user -> {
            if (user.getDest().equals(userid1) && user.getSrc().equals(userid2) || user.getSrc().equals(userid1) && user.getDest().equals(userid2) ) {

                graphRepository.delete(user);
            }
        });

        return userid1;
    }




}
