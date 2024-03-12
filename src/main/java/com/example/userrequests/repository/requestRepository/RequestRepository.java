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

    Page<Request> findAllByStatus(Status status, PageRequest page);

    Page<Request> findAllByStatusNotLike(Status status, PageRequest page);

    Page<Request> findAllByStatusNotLikeAndMyUserUsernameContaining(Status status, String userName, PageRequest page);

    Page<Request> findAllByStatusAndMyUserUsernameContaining(Status status, String userName, PageRequest page);

    Page<Request> findAllByMyUserId(Long id, PageRequest page);
}
