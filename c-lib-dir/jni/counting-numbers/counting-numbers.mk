include $(CLEAR_VARS)

LOCAL_MODULE := libcountingnumbers
LOCAL_SRC_FILES := counting-numbers/counting-numbers.c


LOCAL_CFLAGS := -frtti -fexceptions
LOCAL_LDFLAGS := -Wl,--no-undefined

LOCAL_TARGET_ARCH := armeabi-v7a x86 arm64-v8a

include $(BUILD_SHARED_LIBRARY)
