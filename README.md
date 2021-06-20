# Приложение «Мобильный хоспис»
## Правила нейминга в проекте (*для разрабочиков*):
* Для логики, фрагментов, функций и т.п.:
*Используется Cammel Case*

  Примеры:
  * class MainFragment : Fragment() {}
  * fun convertDate(): String {}
* Для нейминга в xml используется Snake Case. Завершаищим элементом в названии должен идти тип view (полностью):
  
  Примеры:
    * ``` <ImageView
          android:id="@+id/line_divider_image_view"
          android:contentDescription="@string/line_divider_description" />
    ```

    * ``` <androidx.recyclerview.widget.RecyclerView
          android:id="@+id/notes_list_recycler_view" />
    ```
  
    * ```     <string name="date_not_set">Date not set</string>
    ```
