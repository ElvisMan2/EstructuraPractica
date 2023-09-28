package Semanal;

public class numComplex implements numComplejo {
    private float real;
    private float imag;
    public numComplex(float r, float i) {
        real = r;
        imag = i;
    }
    @Override
    public float getReal() {
        return real;
    }
    @Override
    public float getImag() {
        return imag;
    }
    @Override
    public void setReal(float x) {
        real = x;
    }
    @Override
    public void setImag(float x) {
        imag = x;
    }
    @Override
    public numComplejo suma(numComplejo obj) {
        numComplejo result = new numComplex(real + obj.getReal(), imag + obj.getImag());
        return result;
    }
    @Override
    public numComplejo resta(numComplejo obj) {
        numComplejo result = new numComplex(real - obj.getReal(), imag - obj.getImag());
        return result;
    }
    @Override
    public numComplejo multiplicacion(numComplejo obj) {
        numComplejo result = new numComplex(real * obj.getReal() - imag * obj.getImag(),
                real * obj.getImag() + imag * obj.getReal());
        return result;
    }
    @Override
    public float modulo() {
        return (float) Math.sqrt(real * real + imag * imag);
    }
    @Override
    public boolean esigual(numComplejo obj) {
        return (real == obj.getReal() && imag == obj.getImag());
    }
}
