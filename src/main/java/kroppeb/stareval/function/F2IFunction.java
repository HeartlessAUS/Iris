package kroppeb.stareval.function;

import kroppeb.stareval.expression.Expression;

public interface F2IFunction extends TypedFunction{
	int eval(float a);
	
	@Override
	default void evaluateTo(Expression[] params, FunctionContext context, FunctionReturn functionReturn){
		params[0].evaluateTo(context, functionReturn);
		functionReturn.intReturn = this.eval(functionReturn.floatReturn);
	}
	
	@Override
	default Type getReturnType() {
		return Type.Int;
	}
	
	@Override
	default Type[] getParameterTypes() {
		return new Type[]{Type.Float};
	}
}