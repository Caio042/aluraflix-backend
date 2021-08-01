package com.caiolima.AluraFlix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caiolima.AluraFlix.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
	//TODO estratégias de select
}
