include $(CLEAR_VARS)

# Defina o nome do módulo e o nome do arquivo de saída
LOCAL_MODULE := libreadingnumbers
LOCAL_SRC_FILES := reading-numbers/reading-numbers.c


# Defina quaisquer opções adicionais de compilação e linkagem
LOCAL_CFLAGS := -frtti -fexceptions
LOCAL_LDFLAGS := -Wl,--no-undefined

# Defina a arquitetura do destino (por exemplo, armeabi-v7a, arm64-v8a, x86, etc.)
# Você pode ajustar isso para atender às suas necessidades específicas
# Lembre-se de que o NDK suporta várias arquiteturas, então você pode especificar mais de uma
# para criar bibliotecas nativas para várias arquiteturas de destino.
LOCAL_TARGET_ARCH := armeabi-v7a x86 arm64-v8a

include $(BUILD_SHARED_LIBRARY)
