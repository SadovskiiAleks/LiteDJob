package com.example.userrequests.repository.requestRepository;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.role.Role;
import com.example.userrequests.model.status.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {

    List<Request> findAllByStatus(Status status);
    List<Request> findAllByUserRoleName(String name);
    List<Request> findAllByStatusOrStatusOrStatus(Status status1,Status status2, Status status3);

//    @Query("select r from  Request r  join UserRole u on r.userRole = u.id where u.name = :name")
//    List<Request> joinFruit(@Param("name") String name, );

    List<Request> findAllByUserRoleNameAndStatusOrStatusOrStatus(String name, Status status1, Status status2,Status status3);



}
