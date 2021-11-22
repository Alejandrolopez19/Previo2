package co.empresa.test.modelo;



import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor



	public class Candidato implements Serializable {
	 

			private Integer id;
			private String documento;
			private String nombre;
			private String apellido;
			private int eleccion;
			private int numero;
			
			public Candidato (String documento, String nombre, String apellido, int eleccion, int numero) {
				this.documento = documento;
				this.nombre = nombre;
				this.apellido = apellido;
				this.eleccion = eleccion;
				this.numero = numero;
			} 
}
