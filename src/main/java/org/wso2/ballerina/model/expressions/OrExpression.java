/*
*  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.wso2.ballerina.model.expressions;

import org.wso2.ballerina.interpreter.Context;
import org.wso2.ballerina.model.values.BValueRef;
import org.wso2.ballerina.model.values.BooleanValue;

import static org.wso2.ballerina.model.Operator.OR;

/**
 * {@code AndExpression} represents an boolean AND('||') expression in Ballerina
 *
 * @since 1.0.0
 */
public class OrExpression extends BinaryLogicalExpression {
    public OrExpression(Expression lExpr, Expression rExpr) {
        super(lExpr, OR, rExpr);
    }

    public BValueRef evaluate(Context ctx) {
        boolean result = lExpr.evaluate(ctx).getBoolean() || rExpr.evaluate(ctx).getBoolean();
        BooleanValue booleanValue = new BooleanValue(result);
        return new BValueRef(booleanValue);
    }
}