package com.probability;

public class Probability {

    double probabilityValue;
    private final double certainEventProbability = 1;

    public Probability(double probabilityValue) {
        this.probabilityValue = probabilityValue;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }
        if(object == null || this.getClass() != object.getClass()) {
            return false;
        }

        return this.probabilityValue == (((Probability) object).probabilityValue);
    }

    @Override
    public int hashCode() {
        double probabilityValue = this.probabilityValue;   // to follow object calisthenics, separated into two line
        return Double.hashCode(probabilityValue);
    }

    public Probability and(Probability probabilityToBeChecked) {
        return new Probability( this.probabilityValue * probabilityToBeChecked.probabilityValue );
    }

    public Probability or(Probability probabilityToBeChecked) {
        //    (A intersection B)' = A' union B'
        //    A intersection B = (A' union B')'
        return not().and(probabilityToBeChecked.not()).not();
    }

    public Probability not() {

        return new Probability( certainEventProbability - this.probabilityValue );
    }
}
