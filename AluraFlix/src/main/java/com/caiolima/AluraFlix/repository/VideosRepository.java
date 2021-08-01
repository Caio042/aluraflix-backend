package com.caiolima.AluraFlix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caiolima.AluraFlix.model.Videos;

@Repository
public interface VideosRepository extends JpaRepository<Videos, Long> {
	//TODO estratégias de select
}
