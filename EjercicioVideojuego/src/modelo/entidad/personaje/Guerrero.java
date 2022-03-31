package modelo.entidad.personaje;

import modelo.entidad.arma.Arco;
import modelo.entidad.arma.Arma;
import modelo.entidad.arma.Espada;

public class Guerrero extends Personaje{
	
	private Integer fuerza;
	
	public Guerrero(String nombre, Arma arma, Integer vida, Integer velocidad, Integer fuerza) {
		super(nombre, arma, vida, velocidad);
		this.fuerza = fuerza;
	}

	@Override
	public void atacar(Personaje p) {
		Integer da�o = this.getArma().usar();
		if(this.getArma() instanceof Espada || this.getArma() instanceof Arco) {
			da�o = da�o + this.fuerza;
		}
		p.herir(da�o);
		System.out.println("El guerrero " + this.getNombre() + " inflinje " + da�o + " puntos de da�o a " + p.getNombre());
	}
	
	public Integer getFuerza() {
		return fuerza;
	}

	public void setFuerza(Integer fuerza) {
		this.fuerza = fuerza;
	}

}
