LOCAL_PATH := $(call my-dir)

COUNTING_NUMBERS_PATH := $(LOCAL_PATH)/counting-numbers
READING_NUMBERS_PATH := $(LOCAL_PATH)/reading-numbers/


include $(COUNTING_NUMBERS_PATH)/counting-numbers.mk
include $(READING_NUMBERS_PATH)/reading-numbers.mk