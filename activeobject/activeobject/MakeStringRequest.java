package activeobject.activeobject;

class MakeStringRequest extends MethodRequest<String> {

    private final int count;
    private final char fillChar;

    protected MakeStringRequest(Servant servant, FutureResult<String> futureResult, int count, char fillChar) {
        super(servant, futureResult);
        this.count = count;
        this.fillChar = fillChar;
    }

    @Override
    public void execute() {
        Result<String> result = servant.makeString(count, fillChar);
        futureResult.setResult(result);
    }
    
}
