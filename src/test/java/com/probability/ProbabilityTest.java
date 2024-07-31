package com.probability;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProbabilityTest {

    private static Probability probabilityOfHead;
    private static Probability probabilityOfTail;
    private static Probability ceratinEventProbability;
    private static Probability halfProbability;
    private static Probability impossibleEventProbability;

    @BeforeAll
    static void beforeAll() {
        probabilityOfHead = new Probability(0.5);
        probabilityOfTail = new Probability(0.5);

        ceratinEventProbability = new Probability(1);
        impossibleEventProbability = new Probability(0);

        halfProbability = new Probability(0.5);

    }

    @Test
    void toCheckEqualityWhenTheProbabilityOfGettingHeadInACoinIsComparedWithTheProbabilityOfGettingTailInACoin() {

        assertThat(probabilityOfHead, is(equalTo(probabilityOfTail)));
    }

    @Test
    void toCheckInEqualityWhenTheProbabilityOfGettingHeadIsComparedWithProbabilityOfOneInADice() {

        Probability probabilityOfOneInADice = new Probability(0.167);

        assertThat(probabilityOfHead, is(not(equalTo(probabilityOfOneInADice))));
    }

    @Test
    void toCheckWhetherTheProbabilityOfTwoCertainEventsHappeningTogetherIsAlsoAnCertainEvent() {

        assertThat(ceratinEventProbability.and(ceratinEventProbability), is(equalTo(ceratinEventProbability)));
    }

    @Test
    void toCheckWhetherTheQuarterProbabilityEventAndHalfProbabilityEventHappeningTogetherIsOnePointOneTwoFiveProbability() {

        Probability onePointTwoFiveProbability = new Probability(0.125);
        Probability quarterProbability = new Probability(0.25);

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

    @Test
    void toCheckWhetherEitherOfCertainEventOrImpossibleEventOccurringIsCertainEvent() {

        assertThat(ceratinEventProbability.or(impossibleEventProbability), is(equalTo(ceratinEventProbability)));
    }

    @Test
    void toCheckTheProbabilityOfEitherProbabilityOfHeadOrProbabilityOfTailOccurringIsEqualToThreeQuarters() {
        Probability threeQuarters = new Probability(0.75);
        assertThat(probabilityOfHead.or(probabilityOfTail), is(equalTo(threeQuarters)));
    }
}
