/*******************************************************************************
* Copyright 2016 Ivan Shubin http://galenframework.com
* 
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* 
*   http://www.apache.org/licenses/LICENSE-2.0
* 
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
******************************************************************************/
package com.galenframework.parser;

public class ExpectationErrorRate implements Expectation<Integer> {

    @Override
    public Integer read(StringCharReader charReader) {
        Integer initialPosition = charReader.currentCursorPosition();

        Double errorRate = Expectations.number().read(charReader);

        if (!charReader.readWord().equals("px")) {
            charReader.moveCursorTo(initialPosition);
            throw new SyntaxException("Incorrect error rate syntax: \"" + charReader.getTheRest() + "\"");
        }

        return errorRate.intValue();
    }
}
