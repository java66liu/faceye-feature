package com.faceye.component.security.repository.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

public interface AuthRepository {
   public List<?> getUsers();
}
