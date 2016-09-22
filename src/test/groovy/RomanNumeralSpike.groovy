import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by demian on 2016-09-21.
 */
class RomanNumeralSpike extends Specification {

    def romanSolver = {value ->
        'WRONG'
    }

    @Unroll
    def "Roman Numerals solver (non subtractive) #decimal = #romanNumeral"() {
        expect:
        romanSolver(decimal) == romanNumeral

        where:
        decimal     || romanNumeral
        1           || 'I'
        2           || 'II'
        3           || 'III'
        4           || 'IIII'
        5           || 'V'
    }
}
