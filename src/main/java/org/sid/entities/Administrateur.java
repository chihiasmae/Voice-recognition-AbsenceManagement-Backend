package org.sid.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString

public class Administrateur  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
