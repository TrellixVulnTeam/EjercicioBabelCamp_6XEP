package modelo.entidad.arma;

public abstract class Arma{
	
	private Integer da�oBase;

	public Arma(Integer da�oBase) {
		super();
		this.da�oBase = da�oBase;
	}
	
	public Integer usar() {
		return this.getDa�oBase();
	}
	
	public Integer getDa�oBase() {
		return da�oBase;
	}
	
	public void setDa�oBase(Integer da�oBase) {
		this.da�oBase = da�oBase;
	}

}
