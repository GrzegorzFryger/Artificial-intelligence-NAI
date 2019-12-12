# Usage SVM
### DataSet Decryption
The users' knowledge class were classified by the authors
using intuitive knowledge classifier (a hybrid ML technique of k-NN and meta-heuristic exploring methods), k-nearest neighbor algorithm.


### Attribute Information:

STG - The degree of study time for goal object materails. <br/>
SCG -  The degree of repetition number of user for goal object materails <br/>
STR - The degree of study time of user for related objects with goal object <br/>
LPR - The exam performance of user for related objects with goal object <br/>
PEG - The exam performance of user for goal objects <br/>
UNS - The knowledge level of user with values 
Very Low: 1, Low: 2, Middle: 3, High 4


DataSet come frome https://archive.ics.uci.edu/ml/machine-learning-databases/00257/ <br/>

Source:
-- Creators: Hamdi Tolga Kahraman (htolgakahraman '@' yahoo.com)
-- Institution: Faculty of Technology, Department of Software Engineering, Karadeniz Technical University, Trabzon, Turkiye
-- Creators: Ilhami Colak (icolak '@' gazi.edu.tr)
-- Institution: Faculty of Technology, Department of Electrical and Electronics Engineering, Gazi University, Ankara, Turkiye
-- Creators: Seref Sagiroglu (ss '@' gazi.edu.tr)
-- Institution: Faculty of Technology, Department of Computer Engineering, Gazi University, Ankara, Turkiye

-- Donor: undergraduate students of Department of Electrical Education of Gazi University in the 2009 semester
-- Date: October, 2009

###Example results 
RBF

                precision    recall  f1-score   support
       
                1       0.00      0.00      0.00        14
                2       0.54      1.00      0.70        22
                3        0.81     0.77      0.79        22
                4       1.00      0.83      0.90        23
         accuracy                           0.72        81
        macro avg       0.59      0.65      0.60        81
     weighted avg       0.65      0.72      0.66        81



POLY

              precision    recall  f1-score   support

               1       0.00      0.00      0.00         8
               2       0.35      1.00      0.52        26
               3       0.00      0.00      0.00        23
               4       1.00      0.25      0.40        24

         accuracy                           0.40        81
        macro avg       0.34      0.31      0.23        81
     weighted avg       0.41      0.40      0.29        81


SIGMOID

                  precision    recall  f1-score   support
    
               1       0.00      0.00      0.00         9
               2       0.69      1.00      0.82        27
               3       0.79      0.86      0.83        22
               4       1.00      0.78      0.88        23
    
        accuracy                           0.79        81
       macro avg       0.62      0.66      0.63        81
    weighted avg       0.73      0.79      0.75        81

PREDICTED DATA 



                lp   STG   SCG   STR   LPR   PEG   RES
                23   0.18  0.31  0.32  0.42  0.28   2
                25   0.09  0.30  0.68  0.18  0.85   2
                333  0.30  0.16  0.89  0.32  0.95   2
                223  0.68  0.27  0.78  0.31  0.57   2
                367  0.47  0.47  0.25  0.96  0.61   2
                ..    ...   ...   ...   ...   ...
                189  0.49  0.90  0.52  0.90  0.47   4
                30   0.12  0.25  0.75  0.31  0.59   2   
                205  0.62  0.14  0.52  0.81  0.15   2
                374  0.80  0.24  0.23  0.29  0.98   2
                52   0.09  0.55  0.12  0.78  0.05   2

