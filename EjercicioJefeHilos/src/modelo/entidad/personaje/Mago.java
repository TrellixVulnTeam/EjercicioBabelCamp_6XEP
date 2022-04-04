package modelo.entidad.personaje;

import modelo.entidad.arma.Arma;
import modelo.entidad.arma.Hechizo;

public class Mago extends Personaje{

	private Integer inteligencia;

	public Mago(String nombre, Arma arma, Integer vida, Integer velocidad, Integer inteligencia) {
		super(nombre, arma, vida, velocidad);
		this.inteligencia = inteligencia;
	}

	@Override
	public void atacar(Personaje p) {
		Integer da�o = this.getArma().usar();
		if(this.getArma() instanceof Hechizo) {
			da�o = da�o + this.inteligencia;
		}
		p.herir(da�o);
		System.out.println("El mago " + this.getNombre() + " inflinje " + da�o + " puntos de da�o a " + p.getNombre());
	}

	public Integer getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Integer inteligencia) {
		this.inteligencia = inteligencia;
	}

}
