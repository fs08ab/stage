package com.ssit.stage.common.utils;

import com.ssit.stage.common.exception.subtype.ParamInvalidException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 处理数学上的区间
 *
 * @author Fs
 * @since 2017/4/16 17:10
 */
public class RegionUtils {

    public static Region<Integer> getIntegerRegion(String regionStr) {
        return new Region<Integer>(regionStr) {
            @Override
            Integer string2T(String tStr) {
                return Integer.valueOf(tStr);
            }

            @Override
            int compare(Integer t1, Integer t2) {
                return t1.compareTo(t2);
            }
        };
    }


    public static abstract class Region<T> {
        private T min;
        private T max;

        private char leftSymbol;
        private char rightSymbol;

        private char[] expectedLSs = {'[', '('};
        private char[] expectedRSs = {']', ')'};

        Region(String regionStr) {
            String regExp = "^([\\[(])(.+),(.+)([)\\]])$";
            Pattern pattern = Pattern.compile(regExp);
            Matcher matcher = pattern.matcher(regionStr);
            if (matcher.find()) {
                leftSymbol = matcher.group(1).charAt(0);
                min = string2T(matcher.group(2));
                max = string2T(matcher.group(3));
                rightSymbol = matcher.group(4).charAt(0);
            } else {
                throw new ParamInvalidException();
            }
        }

        abstract T string2T(String tStr);

        public boolean isInclude(T t) {
            return t != null
                    && !(leftSymbol == expectedLSs[0] && compare(t, min) < 0)
                    && !(leftSymbol == expectedLSs[1] && compare(t, min) <= 0)
                    && !(rightSymbol == expectedRSs[0] && compare(t, max) > 0)
                    && !(rightSymbol == expectedRSs[1] && compare(t, max) >= 0);
        }

        /**
         * @return <br/>
         * 0:t1=t2 <br/>
         * 1:t1&gt;t2 <br/>
         * -1:t1&lt;t2
         */
        abstract int compare(T t1, T t2);
    }
}
