package com.techprimers.springbootsoapexample.service;

import com.google.gson.Gson;
import com.techprimers.spring_boot_soap_example.*;
import com.techprimers.springbootsoapexample.models.UserModel;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<>();
    private static final List<UserObject> userObject = new ArrayList<>();


    @PostConstruct
    public void initialize() {

        User userOne = new User();
        userOne.setName("Martin");
        userOne.setEmpId(1);
        userOne.setSalary(120000);

        User userTwo = new User();
        userTwo.setName("Yvonne");
        userTwo.setEmpId(2);
        userTwo.setSalary(200000);


        User userThree = new User();
        userThree.setName("Jane");
        userThree.setEmpId(3);
        userThree.setSalary(90000);





        users.put(userOne.getName(), userOne);
        users.put(userTwo.getName(), userTwo);
        users.put(userThree.getName(), userThree);
    }


    public User getUsers(String name) {
        return users.get(name);
    }

    public String registerUser(RegisterUser registerUser)
    {

        if (!userObject.isEmpty())
        {
            for (UserObject singleUser : userObject)
            {
                if (registerUser.getUserObject().getEmail().equalsIgnoreCase(singleUser.getEmail()))
                {
                    return "Email address already in use";
                }

                if (registerUser.getUserObject().getPhoneNumber().equalsIgnoreCase(singleUser.getPhoneNumber()))
                {
                    return "Phone number already in use";
                }
            }
        }


        UserObject userModel = new UserObject();

        userModel.setFirstName(registerUser.getUserObject().getFirstName());
        userModel.setLastName(registerUser.getUserObject().getLastName());
        userModel.setEmail(registerUser.getUserObject().getEmail());
        userModel.setPhoneNumber(registerUser.getUserObject().getPhoneNumber());
        userModel.setPassword(registerUser.getUserObject().getPassword());
        userObject.add(userModel);

        System.out.println(">>>>> Users registered " + new Gson().toJson(userObject));



        return "User registered successfully";
    }

    public LoginUserResponse loginUserResponse (LoginUser loginUser)
    {

        LoginUserResponse response = new LoginUserResponse();


        //Check if there exist users in memory
        if (userObject.isEmpty())
        {
            response.setMessage("User not found");
            return response;
        }


        //If there is users in the memory loop through all matching with the entered details
        for(UserObject singleUser : userObject) {

            //No user found with the entered email and password
            if (!singleUser.getEmail().equalsIgnoreCase(loginUser.getEmail())
                    && (!singleUser.getPassword().equalsIgnoreCase(loginUser.getPassword()))) {
                response.setMessage("User not found");
                return response;
            }

            //User exist with correct details
            if (singleUser.getEmail().equalsIgnoreCase(loginUser.getEmail())
                    && (singleUser.getPassword().equalsIgnoreCase(loginUser.getPassword()))) {
                response.setMessage("Success");
                response.setUserObject(singleUser);
                return response;
            }

                //User is found with the correct email or password
                if (singleUser.getEmail().equalsIgnoreCase(loginUser.getEmail())
                        || (singleUser.getPassword().equalsIgnoreCase(loginUser.getPassword()))) {
                    response.setMessage("Wrong email or password");

                    return response;
                }

            }


        return response;
    }
}
