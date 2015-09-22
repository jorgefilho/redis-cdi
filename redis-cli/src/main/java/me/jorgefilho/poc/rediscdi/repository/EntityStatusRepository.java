package me.jorgefilho.poc.rediscdi.repository;

import java.io.Serializable;

import me.jorgefilho.poc.rediscdi.domain.EntityStatus;

public interface EntityStatusRepository extends Serializable {

	void insert(EntityStatus status);
}
