package com.weak.hashmap;

public class WeakHashMapExample {

	class Employee {

		private Integer id;
		private String name;
		private Double salary;
		private String email;

		public Employee(Integer id, String name, Double salary, String email) {
			this.id = id;
			this.name = name;
			this.salary = salary;
			this.email = email;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((salary == null) ? 0 : salary.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (salary == null) {
				if (other.salary != null)
					return false;
			} else if (!salary.equals(other.salary))
				return false;
			return true;
		}

		private WeakHashMapExample getEnclosingInstance() {
			return WeakHashMapExample.this;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", email=" + email + "]";
		}

	}

	public static void main(String[] args) {

	}

}
