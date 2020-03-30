package br.com.yasuo.maestria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.yasuo.maestria.entity.Personagem;

public interface PersongaemRepository extends JpaRepository<Personagem, Integer>{

}
