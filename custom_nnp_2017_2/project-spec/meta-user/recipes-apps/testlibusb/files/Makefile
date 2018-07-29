APP = testlibusb
LDLIBS += -lusb-1.0

# Add any other object files to this list below
APP_OBJS = testlibusb.o

all: build

build: $(APP)

$(APP): $(APP_OBJS)
	$(CC) $(LDFLAGS) -o $@ $(APP_OBJS)  $(LDLIBS) 

