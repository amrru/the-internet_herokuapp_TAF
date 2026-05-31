package drivers;

public enum browsers {

    CHROME {
        @Override
                public AbstractDriver getDriverFactory(){
            return new ChromeFactory();
        }
    },
    EDGE {
        @Override
        public AbstractDriver getDriverFactory(){
            return new EdgeFactory();
        }
    },
    FIREFOX{
        @Override
        public AbstractDriver getDriverFactory(){
            return new FireFoxFactory();
        }
    };



    public abstract AbstractDriver getDriverFactory();

}
