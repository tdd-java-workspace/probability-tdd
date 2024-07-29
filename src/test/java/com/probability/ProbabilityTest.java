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
}
