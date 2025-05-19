package com.projeto.ads.repositories;

import com.projeto.ads.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("SELECT a FROM Aluno a WHERE a.id=(SELECT MAX(a2.id) FROM Aluno a2)")
    public Aluno findLastInsertedAluno();

    @Query("SELECT a FROM Aluno a WHERE a.cpf=:cpf")
    public Aluno findByCpf(String cpf);


    @Query("SELECT a FROM Aluno a WHERE a.email=:email")
    public Aluno findByEmail(String email);

    @Query("SELECT a FROM Aluno a ORDER BY a.id")
    List<Aluno> findAllOrderedById();


}
