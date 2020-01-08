    Model: "sequential_66"
    _________________________________________________________________
    Layer (type)                 Output Shape              Param #   
    =================================================================
    flatten_60 (Flatten)         (None, 784)               0         
    _________________________________________________________________
    dense_235 (Dense)            (None, 32)                25120     
    _________________________________________________________________
    dense_236 (Dense)            (None, 32)                1056      
    _________________________________________________________________
    dense_237 (Dense)            (None, 32)                1056      
    _________________________________________________________________
    dense_238 (Dense)            (None, 32)                1056      
    _________________________________________________________________
    dense_239 (Dense)            (None, 32)                1056      
    _________________________________________________________________
    dense_240 (Dense)            (None, 32)                1056      
    _________________________________________________________________
    dense_241 (Dense)            (None, 32)                1056      
    _________________________________________________________________
    dense_242 (Dense)            (None, 10)                330       
    =================================================================
    Total params: 31,786
    Trainable params: 31,786
    Non-trainable params: 0
    _________________________________________________________________
    None
    Model 1 result loss: 0.196030
    Model 1 final accuracy: 0.947200
    
   ![alt text](https://github.com/GrzegorzFryger/NAI/blob/master/Lab_06/ex_3/1.png) 

    Model: "sequential_67"
    _________________________________________________________________
    Layer (type)                 Output Shape              Param #   
    =================================================================
    flatten_61 (Flatten)         (None, 784)               0         
    _________________________________________________________________
    dense_243 (Dense)            (None, 64)                50240     
    _________________________________________________________________
    dense_244 (Dense)            (None, 64)                4160      
    _________________________________________________________________
    dense_245 (Dense)            (None, 64)                4160      
    _________________________________________________________________
    dense_246 (Dense)            (None, 64)                4160      
    _________________________________________________________________
    dense_247 (Dense)            (None, 10)                650       
    =================================================================
    Total params: 63,370
    Trainable params: 63,370
    Non-trainable params: 0
    _________________________________________________________________
    None
    Model 2 result loss: 0.143440
    Model 2 final accuracy: 0.960200
    
   ![alt text](https://github.com/GrzegorzFryger/NAI/blob/master/Lab_06/ex_3/2.png)  
   
    Model: "sequential_68"
    _________________________________________________________________
    Layer (type)                 Output Shape              Param #   
    =================================================================
    flatten_62 (Flatten)         (None, 784)               0         
    _________________________________________________________________
    dense_248 (Dense)            (None, 128)               100480    
    _________________________________________________________________
    dense_249 (Dense)            (None, 128)               16512     
    _________________________________________________________________
    dense_250 (Dense)            (None, 128)               16512     
    _________________________________________________________________
    dense_251 (Dense)            (None, 128)               16512     
    _________________________________________________________________
    dense_252 (Dense)            (None, 28)                3612      
    =================================================================
    Total params: 153,628
    Trainable params: 153,628
    Non-trainable params: 0
    _________________________________________________________________
    None
    Model 3 result loss: 14.538524
    Model 3 final accuracy: 0.098000
    
   ![alt text](https://github.com/GrzegorzFryger/NAI/blob/master/Lab_06/ex_3/3.png) 
    
    
     Predict model1 
    
   ![alt text](https://github.com/GrzegorzFryger/NAI/blob/master/Lab_06/ex_3/4.png) 
    
     in the picture you can see :1
    
    
     Predict model2 
    
   ![alt text](https://github.com/GrzegorzFryger/NAI/blob/master/Lab_06/ex_3/5.png)  
    
     in the picture you can see :0
    
    
     Predict model3 
    
   ![alt text](https://github.com/GrzegorzFryger/NAI/blob/master/Lab_06/ex_3/6.png)  
    
     in the picture you can see :9