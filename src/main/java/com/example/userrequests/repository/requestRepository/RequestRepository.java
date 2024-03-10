package com.example.userrequests.repository.requestRepository;

import com.example.userrequests.model.request.Request;
import com.example.userrequests.model.status.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    //List<Request> findAllByStatus(Status status);

    Page<Request> findAllByStatus(Status status, PageRequest page);


    Page<Request> findAllByStatusAndUserRoleUsernameContaining(Status status,String userName, PageRequest page);

    //List<Request> findAllByUserRoleUsername(String name);

    //List<Request> findAllByUserRoleId(Long id);

    //List<Request> findAllByUserRoleId(Long id, Sort sort);

    Page<Request> findAllByUserRoleId(Long id, PageRequest page);

    List<Request> findAllByStatusOrStatusOrStatus(Status status1, Status status2, Status status3);

//    //@Query("select e from Request r left join UserRole u on r.userRole = u.id  where (r.status = 'SEND' or r.status ='DRAFT') and u.id = 1 ORDER BY r.created desc" )
//    List<Request> findAllByFilter();



//    @Query("select r from  Request r  join UserRole u on r.userRole = u.id where u.name = :name")
//    List<Request> joinFruit(@Param("name") String name, );

    List<Request> findAllByUserRoleUsernameAndStatusOrStatusOrStatus(String name, Status status1, Status status2, Status status3);
}
