package algorithms.book.divideAndConquer;

public class SquareMatrix {
  static class Matrix {
    int ul, ur, dl, dr;
    final int size = 2;

    Matrix(int ul, int ur, int dl, int dr) {
      this.ul = ul;
      this.ur = ur;
      this.dl = dl;
      this.dr = dr;
    }

    public int getUl() {
      return ul;
    }

    public int getUr() {
      return ur;
    }

    public int getDl() {
      return dl;
    }

    public int getDr() {
      return dr;
    }

    public int getSize() {
      return size;
    }
  }

  public Matrix identity(int length) {
    return new Matrix(1, 1, 1, 1);
  }

  public boolean isIdentity(Matrix matrix) {
    return matrix.getUl() == 1 && matrix.getUr() == 1 && matrix.getDl() == 1 && matrix.getDr() == 1;
  }

  public Matrix multiplyMatrix(Matrix a, Matrix b) {
    if (isIdentity(a)) return b;
    if (isIdentity(b)) return a;

    int nUl = (a.getUl() * b.getUl()) + (a.getUr() * b.getDl());
    System.out.println(a.getUl() + " * " + b.getUl() + " + " + a.getUr() + " * " + b.getDl() + " = " + nUl);
    int nUr = (a.getUl() * b.getUr()) + (a.getUr() * b.getDr());
    System.out.println(nUr);
    int nDl = (a.getDl() * b.getUl()) + (a.getDr() * b.getDl());
    System.out.println(nDl);
    int nDr = (a.getDl() * b.getUr()) + (a.getDr() * b.getDr());
    System.out.println(nDr);

    return new Matrix(nUl, nUr, nDl, nDr);
  }

  Matrix pow(Matrix matrix, int m) {
    if (m == 0) return identity(matrix.getSize());
    if (m % 2 > 0) return multiplyMatrix(pow(matrix, m - 1), matrix);
    Matrix half = pow(matrix, m / 2);

    return multiplyMatrix(half, half);
  }

  public static void main(String[] args) {
    SquareMatrix test = new SquareMatrix();
    Matrix testM = new Matrix(2, 3, 4, 5);
    Matrix resultM = test.pow(testM, 2);

    System.out.println(resultM.getUl() + " " + resultM.getUr() + " " + resultM.getDl() + " " + resultM.getDr());
  }
}
