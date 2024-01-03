package ba.unsa.etf.rpr;

public class ShapeFactory {
    public Shape createShape(String shape){
        switch(shape) {
            case "Circle":
                return new Circle();
            case "Square":
                return new Square();
            case "Rectangle":
                return new Rectangle();
        }
        return null;
    }
}
