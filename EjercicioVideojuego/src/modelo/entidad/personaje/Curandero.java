package modelo.entidad.personaje;

import modelo.entidad.arma.Arma;
import modelo.entidad.arma.Rezo;

public class Curandero extends Personaje{
	
	private Integer sabiduria;
	
	public Curandero(String nombre, Arma arma, Integer vida, Integer velocidad, Integer sabiduria) {
		super(nombre, arma, vida, velocidad);
		this.sabiduria = sabiduria;
	}

	@Override
	public void atacar(Personaje p) {
		Integer da�o = this.getArma().usar();
		if(this.getArma() instanceof Rezo) {
			da�o = da�o + this.sabiduria;
		}
		p.herir(da�o);
		System.out.println("El curandero " + this.getNombre() + " inflinje " + da�o + " puntos de da�o a " + p.getNombre());
	}

	public Integer getSabiduria() {
		return sabiduria;
	}

	public void setSabiduria(Integer sabiduria) {
		this.sabiduria = sabiduria;
	}

}
