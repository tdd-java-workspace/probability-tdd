package com.probability;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProbabilityTest {

    @Test
    void toCheckEqualityWhenTheProbabilityOfGettingHeadInACoinIsComparedWithTheProbabilityOfGettingTailInACoin() {

        Probability probabilityOfHead = new Probability(0.5);
        Probability probabilityOfTail = new Probability(0.5);

        assertThat(probabilityOfHead, is(equalTo(probabilityOfTail)));
    }

    @Test
    void toCheckInEqualityWhenTheProbabilityOfGettingHeadIsComparedWithProbabilityOfOneInADice() {

        Probability probabilityOfHead = new Probability(0.5);
        Probability probabilityOfOneInADice = new Probability(0.167);

        assertThat(probabilityOfHead, is(not(equalTo(probabilityOfOneInADice))));
    }

    @Test
    void toCheckWhetherTheProbabilityOfTwoCertainEventsHappeningTogetherIsAlsoAnCertainEvent() {

        Probability ceratinEventProbability = new Probability(1);

        assertThat(ceratinEventProbability.and(ceratinEventProbability), is(equalTo(ceratinEventProbability)));
    }

    @Test
    void toCheckWhetherTheQuarterProbabilityEventAndHalfProbabilityEventHappeningTogetherIsOnePointOneTwoFiveProbability() {

        Probability quarterProbability = new Probability(0.25);
        Probability halfProbability = new Probability(0.5);
        Probability onePointTwoFiveProbability = new Probability(0.125);

        assertThat(quarterProbability.and(halfProbability), is(equalTo(onePointTwoFiveProbability)));
    }

    @Test
    void toCheckTheProbabilityOfACertainEventNotOccurringIsEqualToTheProbabilityOfAnImpossibleEvent() {

        Probability ceratinEventProbability = new Probability(1);
        Probability impossibleEventProbability = new Probability(0);

        assertThat(ceratinEventProbability.not(), is(equalTo(impossibleEventProbability)));
    }

    @Test
    void toCheckWhetherTheProbabilityOfHeadInACoinTossNotOccurringIsEqualToHalfProbability() {

        Probability probabilityOfHead = new Probability(0.5);
        Probability halfAProbability = new Probability(0.5);

        assertThat(probabilityOfHead.not(), is(equalTo(halfAProbability)));
    }
}
