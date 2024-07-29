package com.probability;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProbabilityTest {

    private static Probability probabilityOfHead;
    private static Probability probabilityOfTail;
    private static Probability probabilityOfOneInADice;
    private static Probability ceratinEventProbability;
    private static Probability halfProbability;
    private static Probability quarterProbability;
    private static Probability onePointTwoFiveProbability;
    private static Probability impossibleEventProbability;

    @BeforeAll
    static void beforeAll() {
        probabilityOfHead = new Probability(0.5);
        probabilityOfTail = new Probability(0.5);

        probabilityOfOneInADice = new Probability(0.167);

        ceratinEventProbability = new Probability(1);
        impossibleEventProbability = new Probability(0);


        halfProbability = new Probability(0.5);
        quarterProbability = new Probability(0.25);
        onePointTwoFiveProbability = new Probability(0.125);
    }

    @Test
    void toCheckEqualityWhenTheProbabilityOfGettingHeadInACoinIsComparedWithTheProbabilityOfGettingTailInACoin() {

        assertThat(probabilityOfHead, is(equalTo(probabilityOfTail)));
    }

    @Test
    void toCheckInEqualityWhenTheProbabilityOfGettingHeadIsComparedWithProbabilityOfOneInADice() {

        assertThat(probabilityOfHead, is(not(equalTo(probabilityOfOneInADice))));
    }

    @Test
    void toCheckWhetherTheProbabilityOfTwoCertainEventsHappeningTogetherIsAlsoAnCertainEvent() {

        assertThat(ceratinEventProbability.and(ceratinEventProbability), is(equalTo(ceratinEventProbability)));
    }

    @Test
    void toCheckWhetherTheQuarterProbabilityEventAndHalfProbabilityEventHappeningTogetherIsOnePointOneTwoFiveProbability() {

        assertThat(quarterProbability.and(halfProbability), is(equalTo(onePointTwoFiveProbability)));
    }

    @Test
    void toCheckTheProbabilityOfACertainEventNotOccurringIsEqualToTheProbabilityOfAnImpossibleEvent() {

        assertThat(ceratinEventProbability.not(), is(equalTo(impossibleEventProbability)));
    }

    @Test
    void toCheckWhetherTheProbabilityOfHeadInACoinTossNotOccurringIsEqualToHalfProbability() {

        assertThat(probabilityOfHead.not(), is(equalTo(halfProbability)));
    }
}
