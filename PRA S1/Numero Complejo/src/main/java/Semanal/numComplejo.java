package Semanal;

public interface numComplejo {

    public float getReal();

    public float getImag();

    public void setReal(float x);

    public void setImag(float x);

    public numComplejo suma(numComplejo obj);

    public numComplejo resta(numComplejo obj);

    public numComplejo multiplicacion(numComplejo obj);

    public float modulo();

    public boolean esigual(numComplejo obj);

}
