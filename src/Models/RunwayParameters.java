package Models;

public class RunwayParameters {

	// Values should be assigned in terms of the entire runwayArea
	// In runwayArea, start < end

	public Double resa;
	public Double lda;
	public Double tora;
	public Double toda;
	public Double asda;

	public RunwayParameters clone() {
		RunwayParameters clone = new RunwayParameters();
		clone.resa = this.resa;
		clone.lda = this.lda;
		clone.tora = this.tora;
		clone.toda = this.toda;
		clone.asda = this.asda;
		return clone;
	}

}