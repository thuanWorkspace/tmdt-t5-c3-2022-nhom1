package com.example.tmdtnhom1.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.tmdtnhom1.model.File;
import com.example.tmdtnhom1.model.Login;
import com.example.tmdtnhom1.model.Product;
import com.example.tmdtnhom1.model.*;
import com.google.gson.Gson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tmdtnhom1.service.UserService;

/**
 * members must identify parameters, output response in order to use.
 * @author MyPC
 *
 */


@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/userapi")
public class UserController {
	@Autowired
	UserService userService;

    // hieu
    // login by email only.
    //api:  /login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
        try {
            User userExit = userService.findByEmail(login.getEmail());
            String passSha256 = userService.sha256Code(login.getPassword());
            if (userExit == null) {
                return new ResponseEntity<>("email khong ton tai", HttpStatus.BAD_REQUEST);
            }
            if (userExit != null && passSha256.equals(userExit.getPassword())) {
                String token = userService.generateJwtToken(userExit);
                System.out.println(token);
                return new ResponseEntity<String>(token, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("password incorrect", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public FinalToken decode(String token) {
        String tokenDecode = userService.decodeJwt(token);
        TokenItem item = userService.tokenItemFile(tokenDecode);
        FinalToken item2 = new FinalToken(item.getRole(), item.getSub(), new Date(item.getIat() * 1000), new Date(item.getExp() * 1000));
        return item2;
    }

    @PostMapping("/decode-jwt")
    public ResponseEntity<FinalToken> decodeJwt(@RequestBody String token) {
        try {
            FinalToken tk = decode(token);
            return new ResponseEntity<FinalToken>(tk, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public boolean checkLoginService(String token) {
        FinalToken t = decode(token);
        Date d = new Date();
        return t.getExp().getTime() > d.getTime();
    }

    @GetMapping("/checkLogin/{token}")
    public ResponseEntity checkLogin(@PathVariable String token) {
        try {
            if (checkLoginService(token)) {
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

        @GetMapping("/getUserByToken/{token}")
    public ResponseEntity<User> getUserByToken(@PathVariable("token") String token) {
        try {
            Optional<User> getUserBytoken = userService.getUserByToken(token);
            if (getUserBytoken.isPresent() && checkLoginService(token)) {
                return new ResponseEntity<User>(getUserBytoken.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // hieu
    // api: /register
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody Register register) {
        try {
            User userExit = userService.findByEmail(register.getEmail());
            String passSha256 = userService.sha256Code(register.getPassword());
            if (userExit == null) {
                User newUser = userService.insert(new User(register.getUsername(), register.getEmail(), passSha256, 0,
                        "637f93a592c54d6cc0ff507b", register.getGender()));
                return new ResponseEntity<User>(newUser, HttpStatus.OK);
            }
            return new ResponseEntity("email ton tai",HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // hieu
    //api: /googleLogin
    public void googleLogin() {

    }

    // hieu
    // api: /facebookLogin
    public void facebookLogin() {

    }

    // hieu
    // api: /logOut
    public void logOut() {

    }

    // hieu
    // forgot password
    // api: /resetPassword
    public void resetPassword() {

    }

    // hieu
    // api: /changePassword
    @PutMapping("/changePassword/{token}")
    public ResponseEntity changePassword(@RequestBody String password, @PathVariable("token") String token) {
        try {
            Optional<User> userByToken = userService.getUserByToken(token);
            User user = userByToken.get();
            Gson gson = new Gson();
            ChangePassword changePassword11 = gson.fromJson(password, ChangePassword.class);
            System.out.println("pass moi: "+changePassword11.getPassword());
            String newPassSha = userService.sha256Code(changePassword11.getPassword());
            if (userByToken.isPresent() && checkLoginService(token)) {
                System.out.println(newPassSha);
                User updateUserPass = userService.save(new User(user.getId(), user.getUsername(), user.getEmail(), newPassSha, 0,
                        "637f93a592c54d6cc0ff507b", user.getGender()));
//                    User update = userService.mo
                return new ResponseEntity(newPassSha, HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> list = userService.getAllUsers();
            System.out.println(list);

            if (list.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<User>>(list, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<User>> getUsers() {
        System.out.println(userService.getUsers());
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/allrole")
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok().body(userService.getRoles());
    }

    // check running
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        try {
            return new ResponseEntity<String>("hello world", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //phu
    //cap nhat thong tin nguoi dung
//    @PostMapping("/user")
//    public ResponseEntity<User> store(@RequestBody User user) {
//        try {
//            User _user = userService.save(new User(user.getUsername(), user.getEmail(),
//                    user.getPassword(), user.getScore(), user.getRole(), user.getGender(), user.getData()));
//
//            if (_user != null) {
//                return new ResponseEntity<User>(_user, HttpStatus.CREATED);
//            }
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable("id") String id) {
        try {
            Optional<User> userData = userService.findById(id);

            if (userData.isPresent()) {
                User _user = userData.get();
                System.out.println(_user.toString());
//                _user.setEmail(user.getEmail());
                _user.setPassword(user.getPassword());
                _user.setUsername(user.getUsername());
//                _user.setRole(user.getRole());
//                _user.setScore(user.getScore());
                return new ResponseEntity<User>(userService.save(_user), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    viết api chia sẻ thông qua email ( không phải qua id_user nữa) $check$
    -> api get IDbyemail ,fontend xử lí get id và lưu vào userFile
    Nếu không có hoặc tồn tại 2 user có email giống nhau sẽ trả về nocontent
     */
    @GetMapping("/user/findId/{email}")
    public ResponseEntity<String> getIDbyEmail(@PathVariable String email) {
        try {
            User user = userService.findByEmail(email);
            if (user != null) {
                return new ResponseEntity<String>(user.getId(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // phu
    // tu dong tich diem $check$
    @GetMapping("/user/getScore/{user_id}")
    public ResponseEntity<Integer> getScoreOfUser(@PathVariable String user_id) {
        try {
            Optional<User> userData = userService.findById(user_id);
            if (userData.isPresent()) {
                return new ResponseEntity<Integer>(userData.get().getScore(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/user/payment/{user_id}")
    public ResponseEntity<User> updateAfterPayment(@PathVariable("user_id") String user_id,
                                                   @RequestBody Product product) {
        try {
            Optional<User> userData = userService.findById(user_id);

            if (userData.isPresent()) {
                User user = userData.get();
                user.updateScore(product.getScore());
                return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // phu
    // order product
    @PutMapping("/user/payment/{user_id}/{score}")
    public ResponseEntity<User> updateAfterPayment(@PathVariable("user_id") String user_id,
                                                   @PathVariable Integer score) {
        try {
            Optional<User> userData = userService.findById(user_id);

            if (userData.isPresent()) {
                User user = userData.get();
                user.setScore(user.getScore() + score);
                return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
