package com.Capstone.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_utente")
	private Integer id_utente;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="username")
	private String username;
	@Column(name="email")
	private String email;
	@Column(name="pwd")
	private String password;
	@Column(name="address")
	private String address;
	
	public User(String name, String surname, String username, String email, String password, String address) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
	}
	
	
    
    public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}



	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "carrello",
            joinColumns = @JoinColumn(name = "id_utente", referencedColumnName = "id_utente"),
            inverseJoinColumns = @JoinColumn(name = "id_maglia", referencedColumnName = "id_maglia")
    )
    private Set<Maglia> carrello = new HashSet<>();
//	
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//    @JoinTable(name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
//    )
//    private Set<Role> roles = new HashSet<>();
}
