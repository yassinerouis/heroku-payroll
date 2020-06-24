package customers.project.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Role implements Serializable{
		private static final long serialVersionUID = 1L;
		@Id @GeneratedValue
		private Long Id;
		String name;
		public Role() {
			super();
		}
		public Role(Long id, String role) {
			super();
			Id = id;
			this.name = role;
		}
		public String getRole() {
			return name;
		}
		public void setRole(String name) {
			this.name = name;
		}
}
