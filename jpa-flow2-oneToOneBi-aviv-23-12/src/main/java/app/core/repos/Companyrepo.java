package app.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Company;

public interface Companyrepo extends JpaRepository<Company, Integer>{

}
