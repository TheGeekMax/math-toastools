package dev.toastcie.mathtoastools.vector.intvector;

public class Vector2Int {
    int x;
    int y;

    public Vector2Int(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //calculations methods

    public Vector2Int add(Vector2Int other) {
        return new Vector2Int(this.x + other.x, this.y + other.y);
    }

    public Vector2Int subtract(Vector2Int other) {
        return new Vector2Int(this.x - other.x, this.y - other.y);
    }

    public Vector2Int prod(int scalar) {
        return new Vector2Int(this.x * scalar, this.y * scalar);
    }

    public Vector2Int cross(Vector2Int other) {
        return new Vector2Int(this.x * other.y, this.y * other.x);
    }

    public int dot(Vector2Int other) {
        return this.x * other.x + this.y * other.y;
    }
}
